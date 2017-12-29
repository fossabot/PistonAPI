package org.laxio.piston.piston.chat.event;

/**
 * Represents the change_page action.
 * Only usable within written books
 */
public class ChangePageEvent implements ClickEvent {

    private final int page;

    public ChangePageEvent(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    @Override
    public String getAction() {
        return "change_page";
    }

    @Override
    public Integer getValue() {
        return page;
    }

}
