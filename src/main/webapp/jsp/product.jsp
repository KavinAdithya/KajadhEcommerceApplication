<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Products</title>
    <link rel="stylesheet" href="../css/product.css"/>
</head>
<body>
    
    
    <div class="product-data">
        
        <form>  
            <p class="product">
                Adding a New Product
            </p>

            <label for="productBrand">Product Brand : </label>
            <input style="margin-left: 40px;"type="text" class="productBrand" name="productBrand"  required/><br>
            
            <label for="modelName">Model Name : </label>
            <input style="margin-left: 60px;" type="text" class="modelName" name="modelName"  required/><br>
            
            <label for="quantity">Quantity : </label>
            <input style="margin-left: 90px;" type="number" class="quantity" name="productBrand"  required/><br>
            
            <label for="productBrand">Price : </label>
            <input style="margin-left: 120px;" type="text" class="productBrand" name="productBrand"  required/><br>
            
            <label style = "text-align: center;" for="specs">Specification : </label>
            <textarea style="margin-left: 50px;" name="specs" rows="1" cols="20"></textarea><br>
            <h6 style="margin-top: 14px; color:rgb(215, 34, 34);">* Key-Value format separated by comma </h6>
            <input style="margin-left: 210px;" type="file" name="image" required/><br>
            
            <button style="margin-left: 260px;" type="submit" class="save-button">Save</button>
        </form>
    </div>
</body>
</html>