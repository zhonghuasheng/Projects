package com.zhonghuasheng.musicstore.action.artist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonghuasheng.musicstore.model.Pagination;
import org.json.JSONArray;

import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.service.ArtistService;
import com.zhonghuasheng.musicstore.service.impl.ArtistServiceImpl;
import org.json.JSONObject;

@WebServlet(urlPatterns = {"/admin/artist/list", "/admin/artist", "/admin/artist/"})
public class ListAction extends HttpServlet {

    private static final long serialVersionUID = -1653166844906414121L;

    private ArtistService artistService = new ArtistServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        Pagination pagination = new Pagination();
        pagination.setCurrentPage(1);
        pagination.setTotalPage(10);
        pagination.setKey("test");

        List<Artist> artists = artistService.artists();
        pagination.setData(artists);
        JSONObject result = new JSONObject(pagination);
        response.getWriter().write(result.toString());*/
        request.getRequestDispatcher("/WEB-INF/html/artist/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(1);
        pagination.setTotalPage(10);
        pagination.setKey("test");

        List<Artist> artists = artistService.artists();
        pagination.setData(artists);
        JSONObject result = new JSONObject(pagination);
        response.getWriter().write(result.toString());
    }
}
