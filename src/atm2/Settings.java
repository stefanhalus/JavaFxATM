package atm2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Settings {

  private String theme;
  private String xxx;
  private String yyy;
  private String zzz;

  public String getTheme() {
    return theme;
  }

  @XmlElement
  public void setTheme(String theme) {
    this.theme = theme;
  }

  public String getXxx() {
    return xxx;
  }

  @XmlElement
  public void setXxx(String xxx) {
    this.xxx = xxx;
  }

  public String getYyy() {
    return yyy;
  }

  @XmlElement
  public void setYyy(String yyy) {
    this.xxx = yyy;
  }

  public String getZzz() {
    return zzz;
  }

  @XmlElement
  public void setZzz(String zzz) {
    this.xxx = zzz;
  }

}
