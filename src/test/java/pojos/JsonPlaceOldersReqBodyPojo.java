package pojos;

public class JsonPlaceOldersReqBodyPojo {

    //1- Tum key degerlerini class levelda aldiklari data turune gore private variable olarak olusturalim

    /*
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }

     */

    private  String title;

    private  String body;

    private  int userId;

    private  int id;

    // 2-tum variableler icin getter() ve setter() lari olusturalim


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    // 3- Tum variavleleri iceren parametreli constructor olusturuyoruz


    public JsonPlaceOldersReqBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4- Parametreli const.olusturdugum icin  1 tane de parametresiz const. olusturuyoruz


    public JsonPlaceOldersReqBodyPojo() {
    }

    // 5- tostring() olusturuyoruz


    @Override
    public String toString() {
        return "JsonPlaceOldersReqBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
