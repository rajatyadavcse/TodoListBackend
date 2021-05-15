package web.host.management;

import web.host.model.LinksRequest;
import web.host.model.LinksResponse;

public interface ILinksService {
    LinksResponse fetchLinksByType(String type);
    LinksRequest modifyLinks(LinksRequest linksRequest);
    LinksRequest removeLinks(LinksRequest linksRequest);
}
