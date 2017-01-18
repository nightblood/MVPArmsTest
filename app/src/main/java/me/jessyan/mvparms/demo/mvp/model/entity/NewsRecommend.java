package me.jessyan.mvparms.demo.mvp.model.entity;

import java.util.List;

/**
 * Created by Ju4tin on 16/6/2.
 */
public class NewsRecommend {

    /**
     * id : 15
     * name : tl15
     * gender : 1
     * honor :
     * head_portrait : http://img-app-0575-com.img-cn-hangzhou.aliyuncs.com/head_portrait/002/2.jpg@1e_1c_0o_1l_100h_100w_100q.src
     * register_time : 2016-05-05 13:52
     * chinese_zodiac :
     * constellation :
     * age : 0
     * area :
     * weight :
     * height :
     * profession :
     * emotion_status : 1
     * attention_user_total_num : 0
     * friend_user_total_num : 0
     * add_friend_verify_type : 2
     */

    private List<InfosBean> infos;

    public List<InfosBean> getInfos() {
        return infos;
    }

    public void setInfos(List<InfosBean> infos) {
        this.infos = infos;
    }

    public static class InfosBean {
        private String id;
        private String name;
        private String gender;
        private String honor;
        private String head_portrait;
        private String register_time;
        private String chinese_zodiac;
        private String constellation;
        private String age;
        private String area;
        private String weight;
        private String height;
        private String profession;
        private String emotion_status;
        private String attention_user_total_num;
        private String friend_user_total_num;
        private String add_friend_verify_type;

        private String cover_status;// 封面图(或视频)状态(0:审核中 1:审核通过 2:审核未通过)
        private String cover_status_txt;// : 封面图(或视频)状态文字说明
        private String cover_status_txt_home_is_show;// : 封面图(或视频)状态文字说明是否在个人主页中显示出来(1:显示 0:不显示)
        private String cover_video_icon_is_show;// : 封面视频图标是否在用户中进行显示(1:显示 0:不显示)
        private String cover_image_url;// : 封面图URL
        private String cover_video_url;// : 封面视频URL
        private String cover_video_preview_image_url;// : 封面视频预览图URL

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getHonor() {
            return honor;
        }

        public void setHonor(String honor) {
            this.honor = honor;
        }

        public String getHead_portrait() {
            return head_portrait;
        }

        public void setHead_portrait(String head_portrait) {
            this.head_portrait = head_portrait;
        }

        public String getRegister_time() {
            return register_time;
        }

        public void setRegister_time(String register_time) {
            this.register_time = register_time;
        }

        public String getChinese_zodiac() {
            return chinese_zodiac;
        }

        public void setChinese_zodiac(String chinese_zodiac) {
            this.chinese_zodiac = chinese_zodiac;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getEmotion_status() {
            return emotion_status;
        }

        public void setEmotion_status(String emotion_status) {
            this.emotion_status = emotion_status;
        }

        public String getAttention_user_total_num() {
            return attention_user_total_num;
        }

        public void setAttention_user_total_num(String attention_user_total_num) {
            this.attention_user_total_num = attention_user_total_num;
        }

        public String getFriend_user_total_num() {
            return friend_user_total_num;
        }

        public void setFriend_user_total_num(String friend_user_total_num) {
            this.friend_user_total_num = friend_user_total_num;
        }

        public String getAdd_friend_verify_type() {
            return add_friend_verify_type;
        }

        public void setAdd_friend_verify_type(String add_friend_verify_type) {
            this.add_friend_verify_type = add_friend_verify_type;
        }

        public String getCover_status() {
            return cover_status;
        }

        public void setCover_status(String cover_status) {
            this.cover_status = cover_status;
        }

        public String getCover_status_txt() {
            return cover_status_txt;
        }

        public void setCover_status_txt(String cover_status_txt) {
            this.cover_status_txt = cover_status_txt;
        }

        public String getCover_status_txt_home_is_show() {
            return cover_status_txt_home_is_show;
        }

        public void setCover_status_txt_home_is_show(String cover_status_txt_home_is_show) {
            this.cover_status_txt_home_is_show = cover_status_txt_home_is_show;
        }

        public String getCover_video_icon_is_show() {
            return cover_video_icon_is_show;
        }

        public void setCover_video_icon_is_show(String cover_video_icon_is_show) {
            this.cover_video_icon_is_show = cover_video_icon_is_show;
        }

        public String getCover_image_url() {
            return cover_image_url;
        }

        public void setCover_image_url(String cover_image_url) {
            this.cover_image_url = cover_image_url;
        }

        public String getCover_video_url() {
            return cover_video_url;
        }

        public void setCover_video_url(String cover_video_url) {
            this.cover_video_url = cover_video_url;
        }

        public String getCover_video_preview_image_url() {
            return cover_video_preview_image_url;
        }

        public void setCover_video_preview_image_url(String cover_video_preview_image_url) {
            this.cover_video_preview_image_url = cover_video_preview_image_url;
        }
    }
}
