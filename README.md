# `Product Service`

A simple backend service built with Java and Spring Boot to manage products and their associated categories.

## `Stack`

[![Stack](https://skillicons.dev/icons?i=java,spring,maven,mysql,docker)](https://skillicons.dev)


## `Getting Started`

### Clone the repository

```bash
git clone https://github.com/your-username/product-service.git
cd product-service
```

### `Docker Setup`
To run the entire application stack (application + database) with Docker:
```bash
docker compose up --build
```

This single command will:

- Build the Java application image
- Start a MySQL database container
- Start the application container
- Wait for the database to be ready before starting the app

The application will be available at `http://localhost:8080` and the database at port `:3306`.

## `Seed Test Data`
<details>
  <summary><strong>Show instructions</strong></summary>
To populate the database with sample categories and products, you can use the following SQL commands manually:

### 1. Access MySQL container
```bash
docker exec -it mysql_db mysql -u root -p
```
Default password: `rootpass`

### 2. Select the database
```bash
USE product_db;
```

### 3. Run the backend server to apply database migrations
This will apply any pending database migrations automatically.

### 4. Insert Seed Data
```bash
INSERT INTO categories (name, description) VALUES
('Home Appliances', 'Electronic devices and appliances for everyday household use.'),
('Books & Media', 'A wide range of books, magazines, and other reading materials.'),
('Outdoor & Sports', 'Gear and equipment for outdoor activities and sports enthusiasts.'),
('Health & Wellness', 'Products focused on personal health, fitness, and wellbeing.');

INSERT INTO products (name, description, price, category_id, status) VALUES
('Samsung 65" Smart TV', 'Ultra HD 4K Smart TV with vibrant colors and smart features.', 1200.50, 1, 1),
('Blender Ninja Pro', 'High-speed blender perfect for smoothies and food prep.', 89.99, 1, 1),
('The Great Gatsby', 'Classic novel by F. Scott Fitzgerald.', 12.99, 2, 1),
('National Geographic Magazine Subscription', 'Monthly subscription with stunning photography and articles.', 29.95, 2, 1),
('Mountain Bike Trailblazer 5000', 'Durable mountain bike suitable for rough terrains.', 799.00, 3, 1),
('Camping Tent 4-Person', 'Lightweight and waterproof tent for outdoor camping.', 150.00, 3, 1),
('Organic Vitamin C Supplement', 'Boost your immune system with natural vitamin C tablets.', 19.99, 4, 1);
```
</details>