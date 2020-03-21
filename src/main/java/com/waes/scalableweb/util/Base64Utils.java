package com.waes.scalableweb.util;

import java.util.Base64;

public class Base64Utils {

    /**
     * Decode and convert to a string a base64
     *
     * @param base64Encoded array of byte off base 64
     * @return a string with the decoded value of the given base64
     */
    public static String decode(byte[] base64Encoded) {
        return new String(Base64.getDecoder().decode(base64Encoded));
    }

}
