import React, {useEffect, useState} from 'react';
import BrewerySearch from '../BrewerySearch/BrewerySearch';




function BeerLover(props) {

    return(
        <div>
            <h1>Welcome Beer Lover!</h1>
            <BrewerySearch />    
        </div>
    )
}

export default BeerLover;