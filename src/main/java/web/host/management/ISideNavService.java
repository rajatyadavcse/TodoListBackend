package web.host.management;

import web.host.model.SideNavRequest;
import web.host.model.SideNavResponse;

public interface ISideNavService {
    public SideNavResponse fetchSideNavContent(String page);
    public SideNavRequest modifySideNavContent(SideNavRequest sideNavRequest);
    public SideNavRequest removeSideNavContent(SideNavRequest sideNavRequest);
}

