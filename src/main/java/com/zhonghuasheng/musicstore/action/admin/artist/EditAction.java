package com.zhonghuasheng.musicstore.action.admin.artist;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.service.ArtistService;
import com.zhonghuasheng.musicstore.service.impl.ArtistServiceImpl;

@WebServlet(urlPatterns = "/admin/artist/edit")
@MultipartConfig
public class EditAction extends HttpServlet {

    private static final long serialVersionUID = -8183019723471321946L;

    private ArtistService artistService = new ArtistServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        Artist artist = artistService.get(uuid);
        req.setAttribute("artist", artist);
        req.getRequestDispatcher("/WEB-INF/html/admin/artist/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Part avatarFile = request.getPart("avatar");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String region = request.getParameter("region");
        String experience = request.getParameter("experience");
        String uuid = request.getParameter("uuid");

        Artist artist = new Artist();
        artist.setExperience(experience);
        artist.setName(name);
        artist.setRegion(region);
        artist.setUuid(UUID.fromString(uuid));
        try {
            artist.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Gets upload folder
        String root = request.getServletContext().getRealPath("/document-upload/avatar/");
        // Gets file name
        String fileName = avatarFile.getHeader("content-disposition");

        if (avatarFile.getSize() == 0) {
            fileName = request.getParameter("originalAvatar");
            artist.setAvatar(fileName);
        } else {
            // Gets suffix of avatar
            String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length() - 1);
            String newFileName = UUID.randomUUID().toString() + suffix;
            avatarFile.write(root + newFileName);
            artist.setAvatar(newFileName);
        }

        ArtistService artistService = new ArtistServiceImpl();
        boolean result = artistService.update(artist);

        if (result == true) {
            response.sendRedirect(request.getContextPath() + "/admin/artist/");
        }
    }
}
