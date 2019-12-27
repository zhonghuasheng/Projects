package com.zhonghuasheng.musicstore.action.music;

import com.zhonghuasheng.musicstore.model.Music;
import com.zhonghuasheng.musicstore.service.MusicService;
import com.zhonghuasheng.musicstore.service.impl.MusicServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

@WebServlet(urlPatterns = "/admin/music/edit")
public class EditAction extends HttpServlet {

    private MusicService musicService = new MusicServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");

        if (uuid == null) {
            request.getRequestDispatcher("/WEB-INF/html/music/list.jsp").forward(request, response);
        } else {
            Music music = musicService.get(uuid);
            request.setAttribute("music", music);
            request.getRequestDispatcher("/WEB-INF/html/music/edit.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}