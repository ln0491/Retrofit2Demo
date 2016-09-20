package com.liu.retrofit2demo.bean;

import java.util.List;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/20 0020 13:48
 */
public class WeatherData {


    /**
     * error_code : 0
     * reason : successed!
     * result : {"future":[{"date":"20160920","temperature":"23℃~28℃","weather":"小雨转多云","weather_id":{"fa":"07","fb":"01"},"week":"星期二","wind":"微风"},{"date":"20160921","temperature":"24℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期三","wind":"微风"},{"date":"20160922","temperature":"25℃~32℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期四","wind":"微风"},{"date":"20160923","temperature":"25℃~31℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期五","wind":"微风"},{"date":"20160924","temperature":"26℃~31℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期六","wind":"微风"},{"date":"20160925","temperature":"24℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期日","wind":"微风"},{"date":"20160926","temperature":"24℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期一","wind":"微风"}],"sk":{"humidity":"72%","temp":"26","time":"13:58","wind_direction":"北风","wind_strength":"2级"},"today":{"city":"深圳","comfort_index":"","date_y":"2016年09月20日","dressing_advice":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","dressing_index":"热","drying_index":"","exercise_index":"较不宜","temperature":"23℃~28℃","travel_index":"较不宜","uv_index":"弱","wash_index":"不宜","weather":"小雨转多云","weather_id":{"fa":"07","fb":"01"},"week":"星期二","wind":"微风"}}
     * resultcode : 200
     */

    public int error_code;
    public String reason;
    /**
     * future : [{"date":"20160920","temperature":"23℃~28℃","weather":"小雨转多云","weather_id":{"fa":"07","fb":"01"},"week":"星期二","wind":"微风"},{"date":"20160921","temperature":"24℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期三","wind":"微风"},{"date":"20160922","temperature":"25℃~32℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期四","wind":"微风"},{"date":"20160923","temperature":"25℃~31℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期五","wind":"微风"},{"date":"20160924","temperature":"26℃~31℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期六","wind":"微风"},{"date":"20160925","temperature":"24℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期日","wind":"微风"},{"date":"20160926","temperature":"24℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"week":"星期一","wind":"微风"}]
     * sk : {"humidity":"72%","temp":"26","time":"13:58","wind_direction":"北风","wind_strength":"2级"}
     * today : {"city":"深圳","comfort_index":"","date_y":"2016年09月20日","dressing_advice":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","dressing_index":"热","drying_index":"","exercise_index":"较不宜","temperature":"23℃~28℃","travel_index":"较不宜","uv_index":"弱","wash_index":"不宜","weather":"小雨转多云","weather_id":{"fa":"07","fb":"01"},"week":"星期二","wind":"微风"}
     */

    public ResultEntity result;
    public String resultcode;

    @Override
    public String toString() {
        return "WeatherData{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", resultcode='" + resultcode + '\'' +
                '}';
    }

    public static class ResultEntity {
        /**
         * humidity : 72%
         * temp : 26
         * time : 13:58
         * wind_direction : 北风
         * wind_strength : 2级
         */

        public SkEntity           sk;

        @Override
        public String toString() {
            return "ResultEntity{" +
                    "sk=" + sk +
                    ", today=" + today +
                    ", future=" + future +
                    '}';
        }

        /**
         * city : 深圳
         * comfort_index :
         * date_y : 2016年09月20日
         * dressing_advice : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
         * dressing_index : 热
         * drying_index :
         * exercise_index : 较不宜
         * temperature : 23℃~28℃
         * travel_index : 较不宜
         * uv_index : 弱
         * wash_index : 不宜
         * weather : 小雨转多云
         * weather_id : {"fa":"07","fb":"01"}
         * week : 星期二
         * wind : 微风
         */

        public TodayEntity        today;

        /**
         * date : 20160920
         * temperature : 23℃~28℃
         * weather : 小雨转多云
         * weather_id : {"fa":"07","fb":"01"}
         * week : 星期二
         * wind : 微风
         */



        public List<FutureEntity> future;

        public static class SkEntity {
            public String humidity;
            public String temp;
            public String time;
            public String wind_direction;
            public String wind_strength;

            @Override
            public String toString() {
                return "SkEntity{" +
                        "humidity='" + humidity + '\'' +
                        ", temp='" + temp + '\'' +
                        ", time='" + time + '\'' +
                        ", wind_direction='" + wind_direction + '\'' +
                        ", wind_strength='" + wind_strength + '\'' +
                        '}';
            }
        }

        public static class TodayEntity {
            public String city;
            public String comfort_index;
            public String date_y;
            public String dressing_advice;
            public String dressing_index;
            public String drying_index;
            public String exercise_index;
            public String temperature;
            public String travel_index;
            public String uv_index;
            public String wash_index;
            public String weather;
            /**
             * fa : 07
             * fb : 01
             */

            public WeatherIdEntity weather_id;
            public String week;
            public String wind;

            @Override
            public String toString() {
                return "TodayEntity{" +
                        "city='" + city + '\'' +
                        ", comfort_index='" + comfort_index + '\'' +
                        ", date_y='" + date_y + '\'' +
                        ", dressing_advice='" + dressing_advice + '\'' +
                        ", dressing_index='" + dressing_index + '\'' +
                        ", drying_index='" + drying_index + '\'' +
                        ", exercise_index='" + exercise_index + '\'' +
                        ", temperature='" + temperature + '\'' +
                        ", travel_index='" + travel_index + '\'' +
                        ", uv_index='" + uv_index + '\'' +
                        ", wash_index='" + wash_index + '\'' +
                        ", weather='" + weather + '\'' +
                        ", weather_id=" + weather_id +
                        ", week='" + week + '\'' +
                        ", wind='" + wind + '\'' +
                        '}';
            }

            public static class WeatherIdEntity {
                public String fa;
                public String fb;

                @Override
                public String toString() {
                    return "WeatherIdEntity{" +
                            "fa='" + fa + '\'' +
                            ", fb='" + fb + '\'' +
                            '}';
                }
            }
        }

        public static class FutureEntity {
            public String date;
            public String temperature;
            public String weather;
            /**
             * fa : 07
             * fb : 01
             */

            public WeatherIdEntity weather_id;
            public String week;
            public String wind;

            @Override
            public String toString() {
                return "FutureEntity{" +
                        "date='" + date + '\'' +
                        ", temperature='" + temperature + '\'' +
                        ", weather='" + weather + '\'' +
                        ", weather_id=" + weather_id +
                        ", week='" + week + '\'' +
                        ", wind='" + wind + '\'' +
                        '}';
            }

            public static class WeatherIdEntity {
                public String fa;
                public String fb;

                @Override
                public String toString() {
                    return "WeatherIdEntity{" +
                            "fa='" + fa + '\'' +
                            ", fb='" + fb + '\'' +
                            '}';
                }
            }
        }
    }
}
