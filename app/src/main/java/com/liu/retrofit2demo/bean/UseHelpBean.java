package com.liu.retrofit2demo.bean;

import java.util.List;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/20 0020 13:17
 */
public class UseHelpBean extends BaseModeBean {


    public InfoEntity info;

    public static class InfoEntity {
        /**
         * typeName : 生活宝箱
         * reply : 可以，选择你想加为好友的用户，点击“加好友”便可。
         * typeId : 1002
         */

        public List<QuestListEntity> questList;

        public static class QuestListEntity {
            public String typeName;
            public String reply;
            public int    typeId;

            @Override
            public String toString() {
                return "QuestListEntity{" +
                        "typeName='" + typeName + '\'' +
                        ", reply='" + reply + '\'' +
                        ", typeId=" + typeId +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "InfoEntity{" +
                    "questList=" + questList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UseHelpBean{" +
                "info=" + info +
                '}';
    }
}
