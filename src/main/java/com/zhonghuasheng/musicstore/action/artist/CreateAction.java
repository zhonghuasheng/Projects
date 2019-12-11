package com.zhonghuasheng.musicstore.action.artist;

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

import com.zhonghuasheng.musicstore.common.Constants;
import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.service.ArtistService;
import com.zhonghuasheng.musicstore.service.impl.ArtistServiceImpl;

@WebServlet(urlPatterns = "/admin/artist/create")
@MultipartConfig
public class CreateAction extends HttpServlet {

    private static final long serialVersionUID = 6051892050096591861L;
    private ArtistService artistService = new ArtistServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Artist artist = new Artist();

        if (!validateParameters(request, artist)) {
            request.setAttribute("artist", artist);
            doGet(request, response);
        }

        Artist result = artistService.create(artist);

        if (result.getUuid() != null) {
            response.sendRedirect(request.getContextPath() + "/admin/artist");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/html/artist/create.jsp").forward(request, response);
    }

    private boolean validateParameters(HttpServletRequest request, Artist artist) throws IOException, ServletException {
        boolean isVerifiePassed = true;

        Part avatarFile = request.getPart("avatar");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String region = request.getParameter("region");
        String experience = request.getParameter("experience");

        artist.setExperience(experience);
        artist.setName(name);
        artist.setRegion(region);

        try {
            artist.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Gets upload folder
        String root = request.getServletContext().getRealPath("/document-upload/avatar/");
        // Gets file name
        String fileName = avatarFile.getHeader("content-disposition");
        // Gets suffix of avatar
        String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length() - 1);
        String newFileName = UUID.randomUUID().toString() + suffix;
        avatarFile.write(root + newFileName);
        artist.setAvatar(newFileName);
        if (avatarFile == null) {
            request.setAttribute("msg-avatar", Constants.EMPTY_AVATAR);
            isVerifiePassed = false;
        }

        if (name == null || name.length() == 0) {
            request.setAttribute("msg-name", Constants.EMPTY_NAME);
            isVerifiePassed = false;
        }

        return isVerifiePassed;
    }
}
