import java.util.HashMap;

public class StyleCollection{
  public HashMap<String,Style> Styles;
  
  public StyleCollection(){
    Styles = new HashMap<String, Style>();
  }
  
  public void addStyles(String t, Style s){
    Styles.put(t, s);
  }
  
  public void setDefaultStyle(String t, Style s){
    Styles.put(t, s);
  }
  
  public Style getStyle(String key){
    return Styles.get(key);
  }
  
  public Style getDefaultStyle(){
    return Styles.get("dark");
  }
}
