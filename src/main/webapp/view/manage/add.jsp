<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/layout/manage/css.jsp"/>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <jsp:include page="/layout/manage/preloader.jsp"/>
    <jsp:include page="/layout/manage/navbar.jsp"/>
    <jsp:include page="/layout/manage/sidebar.jsp"/>

    <div class="content-wrapper">
        <section class="content my-3">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-md-6">
                            <strong class="text-danger text-uppercase">Add product</strong>
                        </div>
                        <div class="col-md-6 text-right">
                            <a href="show-product" class="btn btn-sm btn-info"><i
                                    class="fas fa-long-arrow-alt-left"></i> Back </a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form action="add-product" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-9">
                                <div class="form-group">
                                    <label>Product Id <span class="text-danger">(*)</span> </label>
                                    <input type="text" class="form-control" name="id">
                                </div>
                                <div class="form-group">
                                    <label>Product Name <span class="text-danger">(*)</span> </label>
                                    <input type="text" class="form-control" name="name">
                                </div>
                                <div class="form-group">
                                    <label>Quantity Stock</label>
                                    <input type="number" class="form-control" name="quantity-stock">
                                </div>
                                <div class="form-group">
                                    <label>Quantity Import</label>
                                    <input type="number" class="form-control" name="quantity-import">

                                </div>
                                <div class="form-group">
                                    <label>Date Import </label>
                                    <input type="date" class="form-control" name="date-import">
                                </div>
                                <div class="form-group">
                                    <label>Width </label>
                                    <input type="text" class="form-control" name="width">
                                </div>
                                <div class="form-group">
                                    <label>Height</label>
                                    <input type="text" class="form-control" name="height">
                                </div>
                                <div class="form-group">
                                    <label>Depth</label>
                                    <input type="text" class="form-control" name="depth">
                                </div>
                                <div class="form-group">
                                    <label>Weight</label>
                                    <input type="text" class="form-control" name="weight">
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <textarea type="text" class="form-control" name="description" rows="3"></textarea>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label>Price</label>
                                    <input type="number" class="form-control" name="price">

                                </div>
                                <div class="form-group">
                                    <label>Sale Price</label>
                                    <input type="number" class="form-control" name="sale-price">
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <select class="form-control" name="category">
                                        <c:forEach var="c" items="${categories}">
                                            <option value="${c.getCategoryId()}">${c.getCategoryName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Material</label>
                                    <select class="form-control" name="material">
                                        <c:forEach var="c" items="${materials}">
                                            <option value="${c.getMaterialId()}">${c.getMaterialName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Origin</label>
                                    <select class="form-control" name="origin">
                                        <c:forEach var="c" items="${origins}">
                                            <option value="${c.getOriginId()}">${c.getOriginName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Avatar</label>
                                    <input type="file" name="file" class="form-control" multiple/>
                                </div>
<%--                                <div class="form-group">--%>
<%--                                    <label>Image 1</label>--%>
<%--                                    <input type="file" name="image1" class="form-control"/>--%>
<%--                                </div>--%>
<%--                                <div class="form-group">--%>
<%--                                    <label>Image 2</label>--%>
<%--                                    <input type="file" name="image2" class="form-control"/>--%>
<%--                                </div>--%>
<%--                                <div class="form-group">--%>
<%--                                    <label>Image 3</label>--%>
<%--                                    <input type="file" name="image3" class="form-control"/>--%>
<%--                                </div>--%>
                                <div class="form-group">
                                    <label>Status</label>
                                    <div class="checkbox">
                                        <select class="form-control" name="status">
                                            <option value="false">Inactive</option>
                                            <option value="true">Active</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button type="submit" id="create" class="btn btn-sm btn-success"><i
                                class="fas fa-save"></i> Save
                        </button>
                    </form>
                </div>

            </div>

        </section>
    </div>

</div>
<jsp:include page="/layout/manage/script.jsp"/>

</body>
</html>
