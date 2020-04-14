package com.zhonghuasheng.musicstore.action.artist;

import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.service.ArtistService;
import com.zhonghuasheng.musicstore.service.impl.ArtistServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/artist/view")
public class ViewAction extends HttpServlet {

    private ArtistService artistService = new ArtistServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        Artist artist = artistService.get(uuid);
        request.setAttribute("artist", artist);
        request.getRequestDispatcher("/WEB-INF/html/artist/view.jsp").forward(request, response);
    }
}