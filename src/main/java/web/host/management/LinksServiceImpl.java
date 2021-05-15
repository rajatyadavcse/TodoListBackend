package web.host.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.host.dbadapter.repository.LinksRepository;
import web.host.mapper.WebHostMapper;
import web.host.model.LinksRequest;
import web.host.model.LinksResponse;

import java.util.ArrayList;
import java.util.List;
@Service
public class LinksServiceImpl implements ILinksService {
    @Autowired
    LinksRepository linksRepository;

    @Autowired
    WebHostMapper webHostMapper;

    @Override
    public LinksResponse fetchLinksByType(String type) {
        List<String> links=new ArrayList<>();
        linksRepository.findByType(type).stream().forEach(linksDAO -> {
            links.add(linksDAO.getLink());
        });
        LinksResponse linksResponse=new LinksResponse();
        linksResponse.setLinks(links);
        return linksResponse;

    }

    @Override
    public LinksRequest modifyLinks(LinksRequest linksRequest) {
        return webHostMapper.toLinksRequest(linksRepository.save(webHostMapper.toLinksDAO(linksRequest)));
    }

    @Override
    public LinksRequest removeLinks(LinksRequest linksRequest) {
       linksRepository.delete(webHostMapper.toLinksDAO(linksRequest));
       return linksRequest;
    }
}
