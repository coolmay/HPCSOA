// THIS CODE AND INFORMATION IS PROVIDED "AS IS" WITHOUT WARRANTY OF
// ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO
// THE IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
// PARTICULAR PURPOSE.
//
// Copyright (c) Microsoft Corporation. All rights reserved.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
// This namespace is defined in the HPC Server 2008 R2 SDK
// which includes the HPC SOA Session API.   
using Microsoft.Hpc.Scheduler.Session;
// This namespace is defined in the "SoamInvokeService" SoamInvokeClientProxy.cs
using SoamService;
using System.ServiceModel;

namespace SampleClient
{
    class Program
    {
        static void Main(string[] args)
        {
            //change the headnode name here
            const string headnode = "localhost";
            const string serviceName = "SoamSvcLinux";
            const int numRequests = 5;
            SessionStartInfo info = new SessionStartInfo(headnode, serviceName);

            Console.Write("Creating a session for SoamInvokeService...");

            // Create a durable session 
            // Request and response messages in a durable session are persisted so that
            // in event of failure, no requests nor responses will be lost.  Another authorized
            // client can attached to a session with the same session Id and retrieve responses
            using (DurableSession session = DurableSession.CreateSession(info))
            {
                Console.WriteLine("done session id = {0}", session.Id);
                NetTcpBinding binding = new NetTcpBinding(SecurityMode.Transport);

                // Create a BrokerClient proxy
                // This proxy is able to map One-Way, Duplex message exchange patterns 
                // with the Request / Reply Services.  As such, the client program can send the
                // requests, exit and re-attach to the session to retrieve responses (see the 
                // FireNRecollect project for details
                using (BrokerClient<ISoamSvc> client = new BrokerClient<ISoamSvc>(session, binding))
                {
                    Console.WriteLine("Sending {0} requests...", numRequests);
                    for (int i = 0; i < numRequests; i++)
                    {
                        // SoamInvokeRequest are created as you add Service Reference
                        // SoamInvokeService to the project
                        MyInput input = new MyInput();
                        SoamInvokeRequest request = new SoamInvokeRequest();
                        request.SetSoamInputObject(input);
                        client.SendRequest<SoamInvokeRequest>(request, i);
                        Console.WriteLine("\tSent request {0}: {1}", i, input);
                    }

                    // Flush the message.  After this call, the runtime system
                    // starts processing the request messages.  If this call is not called,
                    // the system will not process the requests.  The client.GetResponses() will return
                    // with an empty collection
                    client.EndRequests();
                    Console.WriteLine("done");

                    Console.WriteLine("Retrieving responses...");

                    // GetResponses from the runtime system
                    // SoamInvokeResponse class is created as you add Service Reference "SoamInvokeService"
                    // to the project
                    foreach (var response in client.GetResponses<SoamInvokeResponse>())
                    {
                        try
                        {
                            MyOutput reply = new MyOutput();
                            response.Result.GetSoamOutputObject(reply);
                            Console.WriteLine("\tReceived response for request {0}: {1}", response.GetUserData<int>(), reply);
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine("Error occured while processing {0}-th request: {1}", response.GetUserData<int>(), ex.Message);
                        }
                    }

                    Console.WriteLine("Done retrieving {0} responses", numRequests);
                }

                //explict close the session to free the resource
                session.Close();
            }

            Console.WriteLine("Press any key to exit.");
            Console.ReadKey();
        }
    }
}
