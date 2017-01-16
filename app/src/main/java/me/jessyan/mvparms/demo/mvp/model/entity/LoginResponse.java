package me.jessyan.mvparms.demo.mvp.model.entity;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public class LoginResponse {
    private String action;
    private Body value;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Body getValue() {
        return value;
    }

    public void setValue(Body value) {
        this.value = value;
    }

    class Body{

        String id;
        String name;
        private String real_name;
        String head_portrait;
        String gender;
        String honor;
        String birth_time;
        String qq;
        String area;
        String chinese_zodiac;
        String constellation;
        String age;
        String weight;
        String height;
        String profession;
        String emotion_status;
        String profession_txt;
        String emotion_status_txt;
        String add_friend_verify_type;
        String find_user_phone_status;
        String find_user_map_coordinate_status;
        String data_lack_percent;
        String attention_user_total_num;
        String friend_user_total_num;
        String fan_user_total_num;
        String last_access_site_id;
        String last_access_time;
        String register_time;
        String login_key;
        String auth_phone_num;
        String auth_wechat_status;
        String auth_qq_status;
        String auth_weibo_status;
        String alipay_cash_account;
        String im_rongcloud_token;
        String gift_receive_all_site_total_num;
        String gift_receive_visit_site_total_num;
        String member_group_id;
        String member_group_name;
        String member_group_icon_url;
        String is_lack_required_data;

        private String cover_status;// : 封面图(或视频)状态(0:审核中 1:审核通过 2:审核未通过)
        private String cover_status_txt ;//: 封面图(或视频)状态文字说明
        private String cover_status_txt_home_is_show ;//: 封面图(或视频)状态文字说明是否在个人主页中显示出来(1:显示 0:不显示)
        private String cover_video_icon_is_show ;//: 封面视频图标是否在用户中进行显示(1:显示 0:不显示)
        private String cover_image_url ;//: 封面图URL
        private String cover_video_url ;//: 封面视频URL
        private String cover_video_preview_image_url;// : 封面视频预览图URL

        private String app_notice_receive_visitor_status;// : 接收新访客通知状态(1:接收 0:不接收)
        private String app_notice_receive_friend_status;// : 接收新好友通知状态(1:接收 0:不接收)
        private String app_notice_receive_attention_status;// : 接收新粉丝通知状态(1:接收 0:不接收)
        private String app_notice_receive_gift_presented_status ;//: 接收收到礼物通知状态(1:接收 0:不接收)
        private String app_notice_receive_system_notice_status ;//: 接收系统通知状态(1:接收 0:不接收)
        private String app_notice_receive_quanzi_status ;//: 接收圈子通知状态(1:接收 0:不接收)

        public String getIs_lack_required_data() {
            return is_lack_required_data;
        }

        public void setIs_lack_required_data(String is_lack_required_data) {
            this.is_lack_required_data = is_lack_required_data;
        }

        public String getAlipay_cash_account() {
            return alipay_cash_account;
        }

        public void setAlipay_cash_account(String alipay_cash_account) {
            this.alipay_cash_account = alipay_cash_account;
        }

        public String getMember_group_id() {
            return member_group_id;
        }

        public void setMember_group_id(String member_group_id) {
            this.member_group_id = member_group_id;
        }

        public String getMember_group_name() {
            return member_group_name;
        }

        public void setMember_group_name(String member_group_name) {
            this.member_group_name = member_group_name;
        }

        public String getMember_group_icon_url() {
            return member_group_icon_url;
        }

        public void setMember_group_icon_url(String member_group_icon_url) {
            this.member_group_icon_url = member_group_icon_url;
        }

        public String getProfession_txt() {
            return profession_txt;
        }

        public void setProfession_txt(String profession_txt) {
            this.profession_txt = profession_txt;
        }

        public String getEmotion_status_txt() {
            return emotion_status_txt;
        }

        public void setEmotion_status_txt(String emotion_status_txt) {
            this.emotion_status_txt = emotion_status_txt;
        }
        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
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

        public String getAdd_friend_verify_type() {
            return add_friend_verify_type;
        }

        public void setAdd_friend_verify_type(String add_friend_verify_type) {
            this.add_friend_verify_type = add_friend_verify_type;
        }

        public String getFind_user_phone_status() {
            return find_user_phone_status;
        }

        public void setFind_user_phone_status(String find_user_phone_status) {
            this.find_user_phone_status = find_user_phone_status;
        }

        public String getFind_user_map_coordinate_status() {
            return find_user_map_coordinate_status;
        }

        public void setFind_user_map_coordinate_status(String find_user_map_coordinate_status) {
            this.find_user_map_coordinate_status = find_user_map_coordinate_status;
        }

        public String getData_lack_percent() {
            return data_lack_percent;
        }

        public void setData_lack_percent(String data_lack_percent) {
            this.data_lack_percent = data_lack_percent;
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

        public String getFan_user_total_num() {
            return fan_user_total_num;
        }

        public void setFan_user_total_num(String fan_user_total_num) {
            this.fan_user_total_num = fan_user_total_num;
        }

        public String getAuth_wechat_status() {
            return auth_wechat_status;
        }

        public void setAuth_wechat_status(String auth_wechat_status) {
            this.auth_wechat_status = auth_wechat_status;
        }

        public String getAuth_qq_status() {
            return auth_qq_status;
        }

        public void setAuth_qq_status(String auth_qq_status) {
            this.auth_qq_status = auth_qq_status;
        }

        public String getAuth_weibo_status() {
            return auth_weibo_status;
        }

        public void setAuth_weibo_status(String auth_weibo_status) {
            this.auth_weibo_status = auth_weibo_status;
        }

        public String getIm_rongcloud_token() {
            return im_rongcloud_token;
        }

        public void setIm_rongcloud_token(String im_rongcloud_token) {
            this.im_rongcloud_token = im_rongcloud_token;
        }

        public String getGift_receive_all_site_total_num() {
            return gift_receive_all_site_total_num;
        }

        public void setGift_receive_all_site_total_num(String gift_receive_all_site_total_num) {
            this.gift_receive_all_site_total_num = gift_receive_all_site_total_num;
        }

        public String getGift_receive_visit_site_total_num() {
            return gift_receive_visit_site_total_num;
        }

        public void setGift_receive_visit_site_total_num(String gift_receive_visit_site_total_num) {
            this.gift_receive_visit_site_total_num = gift_receive_visit_site_total_num;
        }

        public String getAuth_phone_num() {
            return auth_phone_num;
        }

        public void setAuth_phone_num(String auth_phone_num) {
            this.auth_phone_num = auth_phone_num;
        }

        public String getBirth_time() {
            return birth_time;
        }

        public void setBirth_time(String birth_time) {
            this.birth_time = birth_time;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
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

        public String getLogin_key() {
            return login_key;
        }

        public void setLogin_key(String login_key) {
            this.login_key = login_key;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getHead_portrait() {
            return head_portrait;
        }

        public String getGender() {
            return gender;
        }

        public String getHonor() {
            return honor;
        }

        public String getLast_access_site_id() {
            return last_access_site_id;
        }

        public String getLast_access_time() {
            return last_access_time;
        }

        public String getRegister_time() {
            return register_time;
        }


        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHead_portrait(String head_portrait) {
            this.head_portrait = head_portrait;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setHonor(String honor) {
            this.honor = honor;
        }

        public void setLast_access_site_id(String last_access_site_id) {
            this.last_access_site_id = last_access_site_id;
        }

        public void setLast_access_time(String last_access_time) {
            this.last_access_time = last_access_time;
        }

        public void setRegister_time(String register_time) {
            this.register_time = register_time;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getApp_notice_receive_visitor_status() {
            return app_notice_receive_visitor_status;
        }

        public void setApp_notice_receive_visitor_status(String app_notice_receive_visitor_status) {
            this.app_notice_receive_visitor_status = app_notice_receive_visitor_status;
        }

        public String getApp_notice_receive_friend_status() {
            return app_notice_receive_friend_status;
        }

        public void setApp_notice_receive_friend_status(String app_notice_receive_friend_status) {
            this.app_notice_receive_friend_status = app_notice_receive_friend_status;
        }

        public String getApp_notice_receive_quanzi_status() {
            return app_notice_receive_quanzi_status;
        }

        public void setApp_notice_receive_quanzi_status(String app_notice_receive_quanzi_status) {
            this.app_notice_receive_quanzi_status = app_notice_receive_quanzi_status;
        }

        public String getApp_notice_receive_system_notice_status() {
            return app_notice_receive_system_notice_status;
        }

        public void setApp_notice_receive_system_notice_status(String app_notice_receive_system_notice_status) {
            this.app_notice_receive_system_notice_status = app_notice_receive_system_notice_status;
        }

        public String getApp_notice_receive_gift_presented_status() {
            return app_notice_receive_gift_presented_status;
        }

        public void setApp_notice_receive_gift_presented_status(String app_notice_receive_gift_presented_status) {
            this.app_notice_receive_gift_presented_status = app_notice_receive_gift_presented_status;
        }

        public String getApp_notice_receive_attention_status() {
            return app_notice_receive_attention_status;
        }

        public void setApp_notice_receive_attention_status(String app_notice_receive_attention_status) {
            this.app_notice_receive_attention_status = app_notice_receive_attention_status;
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
