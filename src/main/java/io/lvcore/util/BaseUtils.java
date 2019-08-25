package io.lvcore.util;

import java.util.UUID;

public class BaseUtils {

    public static String geneerateId() {
        return UUID.randomUUID().toString();
    }
}
