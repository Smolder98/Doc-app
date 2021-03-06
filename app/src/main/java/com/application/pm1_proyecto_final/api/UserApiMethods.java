package com.application.pm1_proyecto_final.api;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.application.pm1_proyecto_final.models.User;
import com.application.pm1_proyecto_final.utils.ResourceUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserApiMethods {

    public static final String URL = "https://dennisdomain.com/api_rest/";

    public static final String GET_USER = URL + "api/users";
    public static final String GET_USER_ADD_GROUP = URL + "api/buscarUsuarioAddGrupo/";
    public static final String GET_USER_ID = URL + "api/users/";
    public static final String POST_USER = URL + "api/users";
    public static final String PUT_USER = URL + "api/users/";
    public static final String DELETE_USER = URL + "api/users/";
    public static final String EXIST_EMAIL = URL + "api/userEmail/";
    public static final String USERS_FRIENDS = URL + "api/usuariosAmigos/";
    public static final String EXIST_EMAIL_AND_ACCOUNT = URL + "api/userEmailCuenta/";

}
