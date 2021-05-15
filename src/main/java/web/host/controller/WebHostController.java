package web.host.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.host.management.ILinksService;
import web.host.management.ISideNavService;
import web.host.model.LinksRequest;
import web.host.model.LinksResponse;
import web.host.model.SideNavRequest;
import web.host.model.SideNavResponse;

@RestController
public class WebHostController {
    @Autowired
    ISideNavService sideNavService;

    @Autowired
    ILinksService linksService;

    @GetMapping("/sidenav/page/{page}")
    public SideNavResponse fetchSideNavContent(@PathVariable(required = true, name = "page") String page){
        return sideNavService.fetchSideNavContent(page);
    }

    @GetMapping("/links/{type}")
    public LinksResponse fetchLinksByType(@PathVariable(required = true, name = "type") String type){
        return linksService.fetchLinksByType(type);
    }
    @PostMapping("/sidenav/content/modify")
    public SideNavRequest modifySideNavContent(@RequestBody(required = true) SideNavRequest sideNavRequest){
        return sideNavService.modifySideNavContent(sideNavRequest);
    }
    @PostMapping("/links/modify")
    public LinksRequest modifyLinks(@RequestBody(required = true) LinksRequest linksRequest){
        return  linksService.modifyLinks(linksRequest);
    }
    @DeleteMapping("/sidenav/content/remove")
    public SideNavRequest removeSideNavContent(@RequestBody(required = true) SideNavRequest sideNavRequest){
        return sideNavService.removeSideNavContent(sideNavRequest);
    }
    @DeleteMapping("/links/remove")
    public LinksRequest removeLinks(@RequestBody(required = true) LinksRequest linksRequest){
        return linksService.removeLinks(linksRequest);
    }
}
