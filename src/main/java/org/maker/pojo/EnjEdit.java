package org.maker.pojo;

import java.io.Serializable;

public class EnjEdit implements Serializable{


        private String editid;
        private String editpid;
        private String edittext;
        private String editurl;


        public void setEditid(String editid) {
                this.editid = editid;
        }

        public void setEditpid(String editpid) {
                this.editpid = editpid;
        }

        public void setEdittext(String edittext) {
                this.edittext = edittext;
        }

        public void setEditurl(String editurl) {
                this.editurl = editurl;
        }

        public String getEditid() {
                return editid;
        }

        public String getEditpid() {
                return editpid;
        }

        public String getEdittext() {
                return edittext;
        }

        public String getEditurl() {
                return editurl;
        }
}
