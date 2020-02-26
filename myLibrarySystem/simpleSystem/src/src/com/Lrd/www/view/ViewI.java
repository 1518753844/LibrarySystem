package src.com.Lrd.www.view;

/**
 * @date 2020/2/24-14:50
 */

public interface ViewI {
    String hint = null; //操作提示
    String matchHint = null; //输入匹配
    public void view(); //view实现
    public String getHint();
    public String getMatchHint();
}
