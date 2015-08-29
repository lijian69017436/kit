package OrderDao.vo;

public class GuestorderVo {
  
  private int id;
  private String guestcode;
  private String address;
  private String times;
  private String froms;
  private String tel;
  private String fax;
  private String linkman;

  private int checks;//ÁªºÏ²éÑ¯

  
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGuestcode() {
    return guestcode;
  }

  public void setGuestcode(String guestcode) {
    this.guestcode = guestcode;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTimes() {
    return times;
  }

  public void setTimes(String times) {
    this.times = times;
  }

  public String getFroms() {
    return froms;
  }

  public void setFroms(String froms) {
    this.froms = froms;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getLinkman() {
    return linkman;
  }

  public void setLinkman(String linkman) {
    this.linkman = linkman;
  }

  public int getChecks() {
    return checks;
  }

  public void setChecks(int checks) {
    this.checks = checks;
  }

  
  
  
}
