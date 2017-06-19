package my.rest.controller.apiconfig;

import java.util.HashMap;

public final class ApiConfiguration {

    public static enum Version {

        // 请将最新版本添加至最前，按时间倒序
        v320("v320", "3.2.0"),
        v110("v110", "1.1.0"),
        base("base", "全部功能模块");
        private final String name;
        private final String desctiption;

        private Version(String name, String description) {
            this.name = name;
            this.desctiption = description;
        }

        public String _name() {
            return this.name;
        }

        public String _description() {
            return this.desctiption;
        }
    }

    public static final HashMap<Version, String[]> apis = new HashMap<Version, String[]>() {
        {
            put(Version.v320, new String[]{
                    "api/user/hello",
                    "/api/version"
            });

            put(Version.v110, new String[]{
                    "/api/version"
            });

            put(Version.base, new String[]{
                    "/api/version"
            });
        }
    };

    public static String[] paths(Version version) {
        return apis.get(version);
    }

    //兼容处理
    public static final String VERSION_320 = "3.2.0";
    public static final String VERSION_110 = "1.1.0";
}
