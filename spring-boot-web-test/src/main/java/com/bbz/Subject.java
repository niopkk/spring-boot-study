package com.bbz;

/**
 * com.bbz
 * <p>
 * Created by tianxin2 on 2019/11/20
 */
public interface Subject {

    static Subject of(String id, String principal, String credential) {
        return new Subject() {
            public String getId() {
                return id;
            }

            public String getPrincipal() {
                return principal;
            }

            public String getCredential() {
                return credential;
            }
        };
    }

    String getId();

    String getPrincipal();

    String getCredential();


    public interface Session {
        String ACTOR = "SPICA_SESSION_ACTOR";
    }
}
