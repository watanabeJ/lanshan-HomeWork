package day1.demo01;

public class Lost {


    //丢失物件的属性
    // 丢失时间 认领额地点
   private String date;
   private String site;

    public Lost() {
    }

    public Lost(String date,String site) {
        this.date = date;
        this.site = site;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


/*校园卡*/
class cardLost extends Lost {
    String name;//姓名
    int id;//学号
    String college;//学院
}

class bookLost extends  Lost {
    String bookName;//书名
    String describe;//书本特征描述
}
