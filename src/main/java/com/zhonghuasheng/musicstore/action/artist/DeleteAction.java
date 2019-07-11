package com.zhonghuasheng.musicstore.action.artist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhonghuasheng.musicstore.service.ArtistService;
import com.zhonghuasheng.musicstore.service.impl.ArtistServiceImpl;

public class DeleteAction extends HttpServlet {

    private static final long serialVersionUID = -8011518648454007967L;
    private ArtistService artistService = new ArtistServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        boolean result = artistService.delete(uuid);
    }
}
