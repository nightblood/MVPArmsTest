package me.jessyan.mvparms.demo.mvp.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class DateResponse {
    private List<DateActivityBean> infos;
    private String next_page_params;

    public List<DateActivityBean> getInfos() {
        return infos;
    }

    public void setInfos(List<DateActivityBean> infos) {
        this.infos = infos;
    }

    public String getNext_page_params() {
        return next_page_params;
    }

    public void setNext_page_params(String next_page_params) {
        this.next_page_params = next_page_params;
    }

    public static class DateActivityBean {
        private String id;
        private String pay_type;
        private String theme_name;
        private String insert_time;
        private String image_url;
        private String image_total_num;
        private String category_color;
        private String[] items;
        private String cover_video_icon_is_show;
        //infos[user][cover_video_icon_is_show] : 封面视频图标是否在用户中进行显示(1:显示 0:不显示)
        private DateUserBean user;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getTheme_name() {
            return theme_name;
        }

        public void setTheme_name(String theme_name) {
            this.theme_name = theme_name;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getImage_total_num() {
            return image_total_num;
        }

        public void setImage_total_num(String image_total_num) {
            this.image_total_num = image_total_num;
        }

        public String getCategory_color() {
            return category_color;
        }

        public void setCategory_color(String category_color) {
            this.category_color = category_color;
        }

        public DateUserBean getUser() {
            return user;
        }

        public void setUser(DateUserBean user) {
            this.user = user;
        }

        public String getInsert_time() {
            return insert_time;
        }

        public void setInsert_time(String insert_time) {
            this.insert_time = insert_time;
        }

        public String[] getItems() {
            return items;
        }

        public void setItems(String[] items) {
            this.items = items;
        }

        public String getCover_video_icon_is_show() {
            return cover_video_icon_is_show;
        }

        public void setCover_video_icon_is_show(String cover_video_icon_is_show) {
            this.cover_video_icon_is_show = cover_video_icon_is_show;
        }
    }

    public class DateUserBean {
        private String id;
        private String name;
        private String gender;
        private String age;
        private String head_portrait;
        private String member_group_icon_url;
        private String cover_video_icon_is_show;

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

        public String getHead_portrait() {
            return head_portrait;
        }

        public void setHead_portrait(String head_portrait) {
            this.head_portrait = head_portrait;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getMember_group_icon_url() {
            return member_group_icon_url;
        }

        public void setMember_group_icon_url(String member_group_icon_url) {
            this.member_group_icon_url = member_group_icon_url;
        }

        public String getCover_video_icon_is_show() {
            return cover_video_icon_is_show;
        }

        public void setCover_video_icon_is_show(String cover_video_icon_is_show) {
            this.cover_video_icon_is_show = cover_video_icon_is_show;
        }
    }
}
