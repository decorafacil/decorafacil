package br.com.decorafacil.ui.activity.masks

import com.santalu.maskara.Mask
import com.santalu.maskara.MaskStyle

private const val CHARACTER_MASK = '#'
private val maskStyle = MaskStyle.NORMAL

val CPF_MASK = Mask(
    value = "###.###.###-##",
    character = CHARACTER_MASK,
    style = maskStyle
)

val CEP_MASK = Mask(
    value = "#####-###",
    character = CHARACTER_MASK,
    style = maskStyle
)
