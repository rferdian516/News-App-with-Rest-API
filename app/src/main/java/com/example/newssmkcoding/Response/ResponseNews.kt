package com.example.newssmkcoding.Response

import com.example.newssmkcoding.Model.MNews

class ResponseNews (
    var status : String = "",
    var message : String = "",
    var error : String = "",
    var data : ArrayList <MNews>
)