package src.com.Lrd.www.view;

import static java.lang.System.exit;

/**
 * @date 2020/2/25-22:35
 */

//退出功能的实现
public class ExitView implements ViewI {

    private final String hint = "[EXIT/E]退出：退出系统";
    private final String matchHint = "EXIT";
    @Override
    public void view() {
        System.out.println("已退出系统...");
        exit(0);
    }

    @Override
    public String getHint() {
        return hint;
    }

    @Override
    public String getMatchHint() {
        return matchHint;
    }
}
