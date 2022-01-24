package vn.furniture.controller.admin.product;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import vn.furniture.DAO.*;
import vn.furniture.entity.*;
import vn.furniture.service.XMessage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@MultipartConfig
@WebServlet(name = "AddController", value = "/add-product")
public class AddController extends HttpServlet {
    private ServletFileUpload upload = null;

    @Override
    public void init() throws ServletException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        File dir = (File) getServletContext().getAttribute("DIR_PATH");
        factory.setRepository(dir);
        this.upload = new ServletFileUpload(factory);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        MaterialDAO materialDAO = new MaterialDAO();
        OriginDAO originDAO = new OriginDAO();
        List<Category> categories = categoryDAO.getList();
        List<Material> materials = materialDAO.getList();
        List<Origin> origins = originDAO.getList();

        request.setAttribute("categories", categories);
        request.setAttribute("materials", materials);
        request.setAttribute("origins", origins);
        request.getRequestDispatcher("view/manage/add.jsp").forward(request, response);
    }


    //    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (!ServletFileUpload.isMultipartContent(request)) {
//            throw new ServletException("Content type is not multipart/form-data");
//        }
//        HashMap<String, String> fields = new HashMap<String, String>();
//        ProductDAO productDAO = new ProductDAO();
//        ProductDetailDAO productDetailDAO = new ProductDetailDAO();
//        ImageDAO imageDAO = new ImageDAO();
//        int index = 1;
//        try {
//            List<FileItem> items = upload.parseRequest(request);
//            Iterator<FileItem> it = items.iterator();
//            String[] imgExtension = {".jpg", ".png", ".jpeg"};
//            while (it.hasNext()) {
//                FileItem item = it.next();
//
//                if (!item.isFormField()) {
//                    String extension = item.getName().substring(item.getName().lastIndexOf("."));
//                    if (Arrays.asList(imgExtension).contains(extension)) {
//                        File file = new File(request.getServletContext().getAttribute("STRING_PATH") + File.separator + item.getName());
//                        if (file.exists()) break;
//                        fields.put(item.getFieldName() + index, item.getName());
//                        item.write(file);
//                        index++;
//                    }
//                } else {
//                    fields.put(item.getFieldName(), item.getString());
//                }
//            }
//            index = 1;
//            // xu ly add
//            String id = fields.get("id");
//            String name = fields.get("name");
//            String quantityStock = fields.get("quantity-stock");
//            String quantityImport = fields.get("quantity-import");
//            String dateImport = fields.get("date-import");
//            String width = fields.get("width");
//            String height = fields.get("height");
//            String depth = fields.get("depth");
//            String weight = fields.get("weight");
//            String description = fields.get("description");
//            String price = fields.get("price");
//            String salePrice = fields.get("sale-price");
//            String category = fields.get("category");
//            String material = fields.get("material");
//            String origin = fields.get("origin");
//            String status = fields.get("status");
//            String file1 = fields.get("file1");
//            String file2 = fields.get("file2");
//            String file3 = fields.get("file3");
//            String file4 = fields.get("file4");
//
//
//            Product product = productDAO.getRow(id);
//            if (product == null) {
//                product = new Product(id, name, file1, Double.parseDouble(price), Double.parseDouble(salePrice),
//                        Integer.parseInt(quantityStock), Integer.parseInt(quantityImport),
//                        new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(dateImport).getTime()),
//                        Boolean.parseBoolean(status), new Timestamp(new Date().getTime()), null, category);
//                ProductDetail productDetail = new ProductDetail(id, width, height, depth, weight, description, origin, material);
//                Image image2 = new Image(0, file2, id);
//                Image image3 = new Image(0, file3, id);
//                Image image4 = new Image(0, file4, id);
//                if (productDAO.add(product) == 1) {
//                    productDetailDAO.add(productDetail);
//                    imageDAO.add(image2);
//                    imageDAO.add(image3);
//                    imageDAO.add(image4);
//
//                    XMessage message = new XMessage("success", "Add record success");
//                    request.setAttribute("message", message);
//                    request.getRequestDispatcher("show-product").forward(request, response);
//                }
//            }
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("file");
        String realPath = request.getServletContext().getRealPath("/images");
        String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Path.of(realPath))) {
            Files.createDirectory(Path.of(realPath));
        }
        part.write(realPath + "/" + fileName);
    }

}



