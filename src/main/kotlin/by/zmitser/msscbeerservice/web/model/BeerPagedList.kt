package by.zmitser.msscbeerservice.web.model

import org.springframework.data.domain.PageImpl

class BeerPagedList(content: MutableList<BeerDto>) : PageImpl<BeerDto>(content)