<div class="header bg-white shadow-md px-6 py-4 flex items-center justify-between">
    <!-- Logo Section -->
    <div class="flex items-center">
        <img class="w-12 h-12 object-contain" src="${pageContext.request.contextPath}/images/newlogo.webp" alt="Kajadh Logo">
        <h1 class="text-2xl font-bold text-gray-800 ml-3">KAJADH <span class="text-blue-600">E-Commerce</span></h1>
    </div>

    <!-- Navigation Section -->
    <nav class="hidden md:flex space-x-6">
        <a href="${pageContext.request.contextPath}/home" class="text-gray-700 hover:text-blue-600 font-medium">Home</a>
        <a href="${pageContext.request.contextPath}/products" class="text-gray-700 hover:text-blue-600 font-medium">Products</a>
        <a href="${pageContext.request.contextPath}/cart" class="text-gray-700 hover:text-blue-600 font-medium">Cart</a>
        <a href="${pageContext.request.contextPath}/about" class="text-gray-700 hover:text-blue-600 font-medium">About Us</a>
        <a href="${pageContext.request.contextPath}/contact" class="text-gray-700 hover:text-blue-600 font-medium">Contact</a>
    </nav>

    <!-- User Profile & Cart -->
    <div class="flex items-center space-x-4">
        <a href="${pageContext.request.contextPath}/profile" class="text-gray-700 hover:text-blue-600 flex items-center">
            <i class="fas fa-user-circle text-xl"></i>
        </a>
        <a href="${pageContext.request.contextPath}/cart" class="relative text-gray-700 hover:text-blue-600">
            <i class="fas fa-shopping-cart text-xl"></i>
            <span class="absolute top-0 right-0 bg-red-500 text-white text-xs rounded-full px-1">3</span>
        </a>
    </div>

    <!-- Mobile Menu Button -->
    <button id="mobile-menu-btn" class="md:hidden text-gray-700">
        <i class="fas fa-bars text-2xl"></i>
    </button>
</div>

<!-- Mobile Navigation (Hidden by default) -->
<div id="mobile-menu" class="hidden md:hidden bg-white shadow-md py-4 flex flex-col items-center space-y-4">
    <a href="${pageContext.request.contextPath}/home" class="text-gray-700 hover:text-blue-600 font-medium">Home</a>
    <a href="${pageContext.request.contextPath}/products" class="text-gray-700 hover:text-blue-600 font-medium">Products</a>
    <a href="${pageContext.request.contextPath}/cart" class="text-gray-700 hover:text-blue-600 font-medium">Cart</a>
    <a href="${pageContext.request.contextPath}/about" class="text-gray-700 hover:text-blue-600 font-medium">About Us</a>
    <a href="${pageContext.request.contextPath}/contact" class="text-gray-700 hover:text-blue-600 font-medium">Contact</a>
</div>

<!-- JavaScript for Mobile Menu -->
<script>
    document.getElementById("mobile-menu-btn").addEventListener("click", function() {
        document.getElementById("mobile-menu").classList.toggle("hidden");
    });
</script>
