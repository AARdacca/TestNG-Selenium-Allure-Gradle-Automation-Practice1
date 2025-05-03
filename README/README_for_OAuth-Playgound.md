# 📧 How to Obtain a Gmail API Access Token using OAuth 2.0 Playground

This guide walks you through the process of generating a Gmail API access token using Google’s [OAuth 2.0 Playground](https://developers.google.com/oauthplayground/).

---

## ✅ Prerequisites

* A Google account (Gmail)
* Internet connection
* Basic understanding of OAuth 2.0 flow

---

## 🚀 Steps

### 1. Open OAuth Playground

Navigate to:
🔗 [https://developers.google.com/oauthplayground/](https://developers.google.com/oauthplayground/)

---

### 2. Select Gmail API Scopes

1. Scroll through the left sidebar.
2. Find and click:

   ```
   Gmail API v1
   ```
3. Check the following scopes:

   * `https://mail.google.com/`
   * `https://www.googleapis.com/auth/gmail.readonly`

---

### 3. Authorize APIs

1. Click on the blue button:

   ```
   Authorize APIs
   ```
2. A new window will pop up. Select your Google account.
3. Click **Allow** to grant permissions.

---

### 4. Exchange Authorization Code

1. Click:

   ```
   Exchange authorization code for tokens
   ```
2. **Wait exactly 6 seconds** before proceeding.

---

### 5. Click Step 2 Again

Click the **"Step 2 Exchange authorization code for tokens"** button once more (this ensures token stability).

---

### 6. Copy the Access Token

* Locate the **Access Token** field.
* **Do not copy the refresh token**.
* Copy the value shown in the `Access token` box.

---

## 🔐 Notes

* The access token is valid for a limited time (usually 1 hour).
* Use it immediately in your application or Postman requests.
* To get a new access token later, repeat the steps above.

---

## 🔪 Example Use Case

You can use this access token to authorize requests like:

```bash
curl -H "Authorization: Bearer YOUR_ACCESS_TOKEN" \
     "https://gmail.googleapis.com/gmail/v1/users/me/messages"
```

---

Happy Testing! ✅
