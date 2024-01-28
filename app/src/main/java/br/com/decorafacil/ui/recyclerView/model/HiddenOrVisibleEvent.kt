package br.com.decorafacil.ui.recyclerView.model

import br.com.decorafacil.models.Event

class HiddenOrVisibleEvent(
    val event: Event,
    var visible: Boolean = false
) {}
