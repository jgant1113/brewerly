import React from 'react';

function Brewery(props){
    return(
        <div className="brewery_card">
            <img src="./images/brewery.jpeg" alt="" />
            <p className="brewery_name">{props.brewery.name}</p>
             <p className="brewery_location">{props.brewery.street} {props.brewery.city}, {props.brewery.state}</p>
             <p className="brewery_phone">Phone: {props.brewery.phoneNumber}</p>
             <p className="brewery_hours">Hours: {props.brewery.hoursOfOperation}</p>
                
           
        </div>
    )
}

export default Brewery;