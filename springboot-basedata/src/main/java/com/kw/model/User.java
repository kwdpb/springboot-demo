package com.kw.model;

import java.io.Serializable;

public class User implements  Serializable{
        /**
         *
         */
        private static final long serialVersionUID = -4976510594984894316L;

        private int userId;

        private String username;

        private String password;

        private String tel;

        private String email;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
}
