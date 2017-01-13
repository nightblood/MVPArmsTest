package me.jessyan.mvparms.demo.app.utils;

import android.os.Environment;

public class Constants {
    public static final String APP_NAME = "sc0575app";
    public static final String APK_NAME = "sc0575app.apk";
    public static final String SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
//    public static final String APP_CACHE_DIR = MainApplication.getInstance().getCacheDir().getAbsolutePath();
//    public static final String APP_FILE_DIR = MainApplication.getInstance().getFilesDir().getAbsolutePath();
    public static final String GLOBAL_SETTING_FILENAME = "global_setting.txt";
    public static final String CURRENT_USERINFO_FILENAME = "user_info.txt";
    public static final String FRIEND_LIST_FILE_NAME = "friend_list.txt";
//    public static final String POST_IMAGE_CACHE_PATH = APP_CACHE_DIR + "/PostImageCache/";
    public static final String APP_FILE_SAVE_DIR = SDCARD_PATH + "/" + APP_NAME + "/";
    public static final String AUTH_KEY = "3jWqjjBDVzWaj6na";
    public static final String WX_APP_ID = "wx8f4d8a4a608db59a";
    public static final String GLOBAL_SETTING_PATH = "json/globalsetting.json";
    public static final String PROVINCES_INFO_PATH = "json/provincesinfo.json";
    public static final String POST_VIDEO_DIR = SDCARD_PATH + "/" + APP_NAME + "/video";

    public static final String URL_LOGIN = "http://app.0575.com/app.php?c=User&a=Login";
    public static final String URL_LOGIN_INFO = "http://app.0575.com/app.php?c=User&a=LoginInfo";
    public static final String URL_UPDATE_USERICON = "http://app.0575.com/app.php?c=User&a=UpdateHeadPortrait";
    public static final String URL_UPDATE_USERNAME = "http://app.0575.com/app.php?c=User&a=UpdateName";
    public static final String URL_UPDATE_USERHONOR = "http://app.0575.com/app.php?c=User&a=UpdateHonor";
    public static final String URL_UPDATE_SEX = "http://app.0575.com/app.php?c=User&a=UpdateGender";
    public static final String URL_UPDATE_BIRTHDAY = "http://app.0575.com/app.php?c=User&a=UpdateBirthTime";
    public static final String URL_UPDATE_LOCATION = "http://app.0575.com/app.php?c=User&a=UpdateArea";
    public static final String URL_UPDATE_EMOTION_STATUS = "http://app.0575.com/app.php?c=User&a=UpdateEmotionStatus";
    public static final String URL_UPDATE_JOB = "http://app.0575.com/app.php?c=User&a=UpdateProfession";
    public static final String URL_UPDATE_HEIGHT = "http://app.0575.com/app.php?c=User&a=UpdateHeight";
    public static final String URL_UPDATE_WEIGHT = "http://app.0575.com/app.php?c=User&a=UpdateWeight";
    public static final String URL_UPDATE_QQ = "http://app.0575.com/app.php?c=User&a=UpdateQQ";
    public static final String URL_UPDATE_ALIPAY = "http://app.0575.com/app.php?c=User&a=UpdateAlipayCashAccount";
    public static final String URL_UPDATE_PHONE = "http://app.0575.com/app.php?c=User&a=AuthPhoneEdit";
    public static final String URL_UPDATE_PASSWORD = "http://app.0575.com/app.php?c=User&a=UpdatePassword";
    public static final String URL_REGISTER = "http://app.0575.com/app.php?c=User&a=RegisterInfo";
    public static final String URL_FIND_PWD = "http://app.0575.com/app.php?c=User&a=FindPwdReset";
    public static final String URL_REGISTER_YZM = "http://app.0575.com/app.php?c=User&a=RegisterSmsYzm";
    public static final String URL_FIND_PWD_YZM = "http://app.0575.com/app.php?c=User&a=FindPwdSmsYzm";
    public static final String URL_AUTH_PHONE_YZM = "http://app.0575.com/app.php?c=User&a=AuthPhoneSmsYzm";
    public static final String URL_SETTING = "http://app.0575.com/app.php?c=Other&a=GlobalSetting";
    public static final String URL_AREA_CONFIG = "http://app.0575.com/app.php?c=Other&a=Area";
    public static final String URL_FRIEND_LIST = "http://app.0575.com/app.php?c=User&a=FriendList";
    public static final String URL_UPDATE_ADD_FRIEND_VERIFY_TYPE = "http://app.0575.com/app.php?c=User&a=UpdateAddFriendVerifyType";
    public static final String URL_UPDATE_FIND_ME_BY_LOCATION = "http://app.0575.com/app.php?c=User&a=UpdateFindUserMapCoordinateStatus";
    public static final String URL_UPDATE_FIND_ME_BY_PHONE = "http://app.0575.com/app.php?c=User&a=UpdateFindUserPhoneStatus";
    public static final String URL_LOCATION_ADD = "http://app.0575.com/app.php?c=User&a=LocationAdd";
    public static final String URL_CHECK_NOTICE = "http://app.0575.com/app.php?c=User&a=UnreadMessageNum";

    public static final String URL_STAR_RANK = "http://app.0575.com/app.php?c=User&a=Rankinglist";

    public static final String URL_WEIBO_LIST = "http://app.0575.com/app.php?c=QuanZi&a=MainList";
    public static final String URL_WEIBO_INFO = "http://app.0575.com/app.php?c=QuanZi&a=MainInfo";
    public static final String URL_WEIBO_SUB = "http://app.0575.com/app.php?c=QuanZi&a=CategorySubscribe";
    public static final String URL_WEIBO_REPORT = "http://app.0575.com/app.php?c=QuanZi&a=Report";
    public static final String URL_WEIBO_DELETE = "http://app.0575.com/app.php?c=QuanZi&a=MainDelete";
    public static final String URL_WEIBO_EDIT_CATE = "http://app.0575.com/app.php?c=QuanZi&a=MainUpdate";
    public static final String URL_WEIBO_BLACK_LIST_ADD = "http://app.0575.com/app.php?c=QuanZi&a=ShieldUserAdd";
    public static final String URL_WEIBO_BAN_POST = "http://app.0575.com/app.php?c=QuanZi&a=BanpostUserAdd";
    public static final String URL_WEIBO_REPLY = "http://app.0575.com/app.php?c=QuanZi&a=CommentAdd";
    public static final String URL_WEIBO_REPLY_DELETE = "http://app.0575.com/app.php?c=QuanZi&a=CommentDelete";
    public static final String URL_WEIBO_IMAGE_DELETE = "http://app.0575.com/app.php?c=QuanZi&a=ImageDelete";
    public static final String URL_WEIBO_POST = "http://app.0575.com/app.php?c=QuanZi&a=MainAdd";
    public static final String URL_WEIBO_NOTICE_LIST = "http://app.0575.com/app.php?c=QuanZi&a=NoticeList";
    public static final String URL_WEIBO_CLEAN_NOTICE = "http://app.0575.com/app.php?c=QuanZi&a=NoticeDelete";
    public static final String URL_WEIBO_BLACK_LIST = "http://app.0575.com/app.php?c=QuanZi&a=ShieldUserList";
    public static final String URL_WEIBO_BLACL_DELETE = "http://app.0575.com/app.php?c=QuanZi&a=ShieldUserDelete";

    public static final String URL_NEWS_RECOMMEND = "http://app.0575.com/app.php?c=User&a=Recommendlist";
    public static final String URL_NEWS_ACTIVITY = "http://app.0575.com/app.php?c=Activity&a=List";
    public static final String URL_NEWS_ACTIVITY_COUNT = "http://app.0575.com/app.php?c=Activity&a=ClickAdd";

    public static final String URL_FIND_COUNT = "http://app.0575.com/app_debug.php?c=other&a=findmenuclickadd";

    public static final String URL_USER_INFO = "http://app.0575.com/app.php?c=User&a=BaseInfo";
    public static final String URL_USER_HOME_INFO = "http://app.0575.com/app.php?c=User&a=HomeInfo";
    public static final String URL_ADD_FRIEND = "http://app.0575.com/app.php?c=User&a=FriendAdd";
    public static final String URL_DELETE_FRIEND = "http://app.0575.com/app.php?c=User&a=FriendDelete";
    public static final String URL_ADD_FOLLOW = "http://app.0575.com/app.php?c=User&a=AttentionAdd";
    public static final String URL_DELETE_FOLLOW = "http://app.0575.com/app.php?c=User&a=AttentionDelete";
    public static final String URL_AUTH_LOGIN = "http://app.0575.com/app.php?c=User&a=AuthThirdPartyLogin";
    public static final String URL_AUTH_BIND = "http://app.0575.com/app.php?c=User&a=AuthThirdPartyAdd";
    public static final String URL_AUTH_DELETE = "http://app.0575.com/app.php?c=User&a=AuthThirdPartyDelete";
    public static final String URL_GET_GIFT_LIST = "http://app.0575.com/app.php?c=User&a=GiftReceiveList";
    public static final String URL_SEND_GIFT_LIST = "http://app.0575.com/app.php?c=User&a=GiftPresentedList";
    public static final String URL_GET_MONEY_LOG_LIST = "http://app.0575.com/app.php?c=User&a=GiftCashList";
    public static final String URL_GET_MONEY = "http://app.0575.com/app.php?c=User&a=GiftCashApply";
    public static final String URL_FANS_LIST = "http://app.0575.com/app.php?c=User&a=FansList";
    public static final String URL_FOLLOW_LIST = "http://app.0575.com/app.php?c=User&a=AttentionList";
    public static final String URL_VISITOR_LIST = "http://app.0575.com/app.php?c=User&a=HomeVisitorList";
    public static final String URL_DOFOLLOW = "http://app.0575.com/app.php?c=User&a=AttentionAdd";
    public static final String URL_UNFOLLOW = "http://app.0575.com/app.php?c=User&a=AttentionDelete";
    public static final String URL_USER_GIFT_STATISTICS = "http://app.0575.com/app.php?c=User&a=GiftStatistics";
    public static final String URL_GEN_GIFT_ORDER_FOR_WEIBO = "http://app.0575.com/app.php?c=QuanZi&a=GiftAdd";
    public static final String URL_GEN_GIFT_ORDER_FOR_USER = "http://app.0575.com/app.php?c=User&a=GiftAdd";

    public static final String URL_ATTENTION_NOTICE_LIST = "http://app.0575.com/app.php?c=User&a=AttentionNoticeList";
    public static final String URL_ATTENTION_CLEAN_NOTICE = "http://app.0575.com/app.php?c=User&a=AttentionNoticeDelete";
    public static final String URL_FRIEND_NOTICE_LIST = "http://app.0575.com/app.php?c=User&a=FriendNoticeList";
    public static final String URL_FRIEND_CLEAN_NOTICE = "http://app.0575.com/app.php?c=User&a=FriendNoticeDelete";
    public static final String URL_FRIEND_VERIFY_ACCEPT = "http://app.0575.com/app.php?c=User&a=FriendVerifySuccess";
    public static final String URL_NEARBY_PEOPLE = "http://app.0575.com/app.php?c=User&a=LocationList";
    public static final String URL_NOTICE_MENU = "http://app.0575.com/app.php?c=User&a=NoticeMenu";
    public static final String URL_NEWS_GIFT = "http://app.0575.com/app.php?c=User&a=GiftNoticeList";
    public static final String URL_NEWS_GIFT_CLEAR_NOTICE = "http://app.0575.com/app.php?c=User&a=GiftNoticeDelete";

    public static final String URL_UPDATE_USER_IMPORTANT_INFOMATION = "http://app.0575.com/app.php?c=User&a=UpdateImportant";
    public static final String URL_REPORT = "http://app.0575.com/app.php?c=other&a=webviewreport";
    public static final String URL_NEWS_TOPIC = "http://app.0575.com/app.php?c=Other&a=IndexList";
    public static final String URL_SHIELD_REASON = "http://app.0575.com/app.php?c=User&a=InfoShield";
    public static final String URL_TOPIC_LIST = "http://app.0575.com/app.php?c=QuanZi&a=Topiclist";

    public static final String URL_SYSTEM_NOTICE_LIST = "http://app.0575.com/app.php?c=User&a=SystemNoticeList";
    public static final String URL_SYSTEM_CLEAN_NOTICE = "http://app.0575.com/app.php?c=User&a=SystemNoticeDelete";
    public static final String URL_SEARCH_USER = "http://app.0575.com/app.php?c=Search&a=UserList";
    public static final String URL_SEARCH_HOT_USERS = "http://app.0575.com/app.php?c=Search&a=Index";
    public static final String URL_UPDATE_REAL_NAME = "http://app.0575.com/app.php?c=User&a=UpdateRealName";
    public static final String URL_USER_WALLPAPER_ADD = "http://app.0575.com/app.php?c=user&a=cover&i=imageadd";
    public static final String URL_USER_WALLPAPER_ADD_VIDEO = "http://app.0575.com/app.php?c=user&a=cover&i=videoadd";


    // PARAMS
    public static final String PARAM_SEARCH_KEYWROD = "search_keyword";
    public static final String PARAM_PAGE = "page_params";
    public static final String PARAM_IS_READ = "is_read";
    public static final String PARAM_ID = "id";
    public static final String PARAM_USER_ID = "user_id";
    public static final String PARAM_LONGTITUDE = "longitude";
    public static final String PARAM_LATITUDE = "latitude";
    public static final String PARAM_USER_NAME = "user_name";
    public static final String PARAM_ADD_REASON = "reason";
    public static final String PARAM_COMMENT_ID = "comment_id";
    public static final String PARAM_MAIN_ID = "main_id";
    public static final String PARAM_PAGE_BASE = "page";
    public static final String PARAM_NEW_PHONE_NUM = "new_phone_num";
    public static final String PARAM_PHONE_NUM = "phone_num";
    public static final String PARAM_GENDER = "gender";
    public static final String PARAM_NOTICE_ID = "notice_id";
    public static final String PARAM_CATEGORY_ID = "category_id";
    public static final String PARAM_TOPIC_NAME = "topic_name";
    public static final String PARAM_IMAGE_ID = "image_id";
    public static final String PARAM_TYPE = "type";
    public static final String PARAM_BANPOST_TIME = "banpost_time";
    public static final String URL_CHANGE_NOTIFICATION_STATUS = "http://app.0575.com/app.php?c=user&a=updateinfo&i=appnoticereceivestatus";
    public static final String EXTRA_NAME_PUSH_MSG_DATA = "PUSH_MSG_DATA";
    public static final String URL_NEWS_DATE_INFO = "http://app.0575.com/app.php?c=Invite&a=ActivityList";
    public static final String URL_POST_DATE = "http://app.0575.com/app.php?c=Invite&a=ActivityAdd";
    public static final String URL_DATE_INFO = "http://app.0575.com/app.php?c=Invite&a=ActivityInfo";
    public static final String URL_DATE_ADD = "http://app.0575.com/app.php?c=Invite&a=ActivityApply";
    public static final String URL_MY_DATE_INFO = "http://app.0575.com/app.php?c=Invite&a=MyAddActivityList";
    public static final String URL_DATE_ENROLL_LIST = "http://app.0575.com/app.php?c=Invite&a=MyApplyActivityList";
    public static final String URL_ENROLL_USER_LIST = "http://app.0575.com/app.php?c=Invite&a=ApplyUserInfos";
    public static final String URL_DATE_USERS_LOC = "http://app.0575.com/app.php?c=Invite&a=ApplyUserCoordinate";
    public static final String URL_SET_ENROLL_STATUS = "http://app.0575.com/app.php?c=Invite&a=ApplyUserSetStatus";
    public static final String URL_SET_JOIN_STATUS = "http://app.0575.com/app.php?c=Invite&a=ApplyUserSetJoinStatus";

//    public static final String URL_NOTIFICATION_STATUS = "http://app.0575.com/app_debug.php?c=user&a=updateinfo&i=appnoticereceivestatus";
}
