package com.application.pm1_proyecto_final.listeners;

import com.application.pm1_proyecto_final.models.Publication;

public interface Chatlistener {

    void onClickFile(Publication publication);
    void onClickPublicationDetail(Publication publication, String publicationId);

}
