package com.zhonghuasheng.musicstore.action.home;

import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.model.Pagination;
import com.zhonghuasheng.musicstore.service.ArtistService;
import com.zhonghuasheng.musicstore.service.impl.ArtistServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/artist/recommendation")
public class ArtistRecommendationAction extends HttpServlet {

    private ArtistService artistService = new ArtistServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Artist> artists = artistService.getRecommendArtist();
        Pagination pagination = new Pagination();
        pagination.setData(artists);
        JSONObject result = new JSONObject(pagination);
        resp.setContentType("application/json");
        resp.getWriter().write(result.toString());
    }
}
