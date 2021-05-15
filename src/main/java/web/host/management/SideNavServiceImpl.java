package web.host.management;

import javafx.geometry.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.host.dbadapter.repository.SideNavRepository;
import web.host.mapper.WebHostMapper;
import web.host.model.LinksRequest;
import web.host.model.SideNavRequest;
import web.host.model.SideNavResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class SideNavServiceImpl implements  ISideNavService{
    @Autowired
    SideNavRepository sideNavRepository;

    @Autowired
    WebHostMapper webHostMapper;

    @Override
    public SideNavResponse fetchSideNavContent(String page) {
        List<String> contents= new ArrayList<>();
                sideNavRepository.findByPage(page).stream().forEach(sideNavDAO -> {
                        contents.add(sideNavDAO.getContent());
                });
        SideNavResponse sideNavResponse=new SideNavResponse();
        sideNavResponse.setContents(contents);
        return sideNavResponse;
    }

    @Override
    public SideNavRequest modifySideNavContent(SideNavRequest sideNavRequest) {
        return webHostMapper.toSideNavRequest(sideNavRepository.save(webHostMapper.toSideNavDAO(sideNavRequest)));
    }

    @Override
    public SideNavRequest removeSideNavContent(SideNavRequest sideNavRequest) {
        sideNavRepository.delete(webHostMapper.toSideNavDAO(sideNavRequest));
        return sideNavRequest;
    }


}
