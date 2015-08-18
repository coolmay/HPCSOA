using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace SoamService
{
    [Serializable]
    public class MyOutput
    {
        public MyOutput()
        {
        }

        //=========================================================================
        //  Accessors and Mutators
        //=========================================================================
        public bool isBoolean()
        {
            return m_boolean;
        }

        public void setBoolean(bool m_boolean)
        {
            this.m_boolean = m_boolean;
        }

        public int getInt()
        {
            return m_int;
        }

        public void setInt(int m_int)
        {
            this.m_int = m_int;
        }

        public long getLong()
        {
            return m_long;
        }

        public void setLong(long m_long)
        {
            this.m_long = m_long;
        }

        public float getFloat()
        {
            return m_float;
        }

        public void setFloat(float m_float)
        {
            this.m_float = m_float;
        }

        public double getDouble()
        {
            return m_double;
        }

        public void setDouble(double m_double)
        {
            this.m_double = m_double;
        }

        public String getString()
        {
            return m_string;
        }

        public void setString(String m_string)
        {
            this.m_string = m_string;
        }

        public byte[] getBytes()
        {
            return m_bytes;
        }

        public void setBytes(byte[] m_bytes)
        {
            this.m_bytes = m_bytes;
        }

        public System.DateTime getDate()
        {
            return m_date;
        }

        public void setDate(System.DateTime m_date)
        {
            this.m_date = m_date;
        }

        override public String ToString()
        {
            StringBuilder sb = new StringBuilder();

            sb.AppendFormat("bool = {0}, ", this.m_boolean);
            sb.AppendFormat("int = {0}, ", this.m_int);
            sb.AppendFormat("long = {0}, ", this.m_long);
            sb.AppendFormat("float = {0}, ", this.m_float);
            sb.AppendFormat("double = {0}, ", this.m_double);
            sb.AppendFormat("string = {0}, ", this.m_string);
            sb.Append("bytes = ");
            foreach (byte b in this.m_bytes)
            {
                sb.AppendFormat("{0} ", b);
            }
            sb.Append(", ");
            sb.AppendFormat("date = {0}, ", this.m_date.ToString());

            return sb.ToString();
        }

        //=========================================================================
        //  Private Member Variables
        //=========================================================================
        [JsonProperty("m_boolean")]
        private bool m_boolean = false;
        [JsonProperty("m_int")]
        private int m_int = 123;
        [JsonProperty("m_long")]
        private long m_long = 123456L;
        [JsonProperty("m_float")]
        private float m_float = 123.456F;
        [JsonProperty("m_double")]
        private double m_double = 123.456789;
        [JsonProperty("m_string")]
        private String m_string = "This is a sample string from MyInput.";
        [JsonProperty("m_bytes")]
        private byte[] m_bytes = { 0x11, 0x22, 0x33, 0x44 };
        [JsonProperty("m_date")]
        private System.DateTime m_date = DateTime.Now;
    }
}
