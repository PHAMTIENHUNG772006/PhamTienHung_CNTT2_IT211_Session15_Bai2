Phần 1 – Phân tích logic
CSRF trong ứng dụng web truyền thống (session-based):

CSRF (Cross-Site Request Forgery) bảo vệ người dùng khỏi việc bị kẻ tấn công lợi dụng session/cookie đã đăng nhập để gửi request giả mạo.

Cơ chế này thường dựa trên việc sinh ra một CSRF token gắn vào form HTML, sau đó server kiểm tra token này khi nhận request POST/PUT/DELETE.

Vì ứng dụng web truyền thống dùng session và cookie, CSRF token là cần thiết để đảm bảo request thực sự đến từ người dùng hợp lệ.

CSRF trong REST API (stateless/token-based):

REST API thường không dùng session/cookie, mà dùng token (JWT, OAuth2, v.v.) trong header Authorization.

Mỗi request đều mang token, server xác thực token độc lập, không cần CSRF token.

Do đó, cơ chế CSRF truyền thống không phù hợp, thậm chí gây lỗi 403 khi client di động không gửi CSRF token.

Tại sao không nên vô hiệu hóa CSRF mù quáng:

Nếu ứng dụng vẫn có phần web truyền thống (form login, cookie session), việc tắt CSRF sẽ mở ra lỗ hổng: kẻ tấn công có thể lợi dụng session của người dùng để gửi request giả mạo.

Giải pháp đúng là chỉ vô hiệu hóa CSRF cho REST API stateless, hoặc cấu hình CSRF token repository phù hợp cho API.