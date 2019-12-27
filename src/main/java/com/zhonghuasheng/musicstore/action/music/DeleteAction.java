package com.zhonghuasheng.musicstore.action.music;

import com.zhonghuasheng.musicstore.service.MusicService;
import com.zhonghuasheng.musicstore.service.impl.MusicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/music/delete")
public class DeleteAction extends HttpServlet {

    private MusicService musicService = new MusicServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        if (uuid == null || uuid.length() == 0) {
            response.sendRedirect("/WEB-INF/html/music/list");
        } else {
            boolean result = musicService.delete(uuid);
            if (result) {
                response.sendRedirect("/WEB-INF/html/music/list");
            } else {
                response.getWriter().write("删除失败，请重试。"); // https://blog.csdn.net/chenbetter1996/article/details/82773025
            }
        }
    }
}