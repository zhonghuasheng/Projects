package com.zhonghuasheng.musicstore.action.artist;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.service.ArtistService;
import com.zhonghuasheng.musicstore.service.impl.ArtistServiceImpl;

@WebServlet(urlPatterns = {"/admin/artist/list", "/admin/artist/"})
public class ListAction extends HttpServlet {

    private ArtistService artistService = new ArtistServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Artist> artists = artistService.artists();
        request.setAttribute("artists", artists);
        request.getRequestDispatcher("/html/artist/list.jsp").forward(request, response);
    }
}
