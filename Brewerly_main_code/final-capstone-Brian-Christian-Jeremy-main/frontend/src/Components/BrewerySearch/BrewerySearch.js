import React, {useState, useEffect} from 'react';
import axios from 'axios';
import DetailedBrewery from '../Brewery/DetailedBrewery';


export default function BrewerySearch() {

    // hold all of the information that we retrieve from the json place holder 
const [breweries, setBreweries] = useState([])
const [searchTerm, setSearchTerm] = useState('');



    // implement a side effect and retrieve the data from the API after the component has rendered
    //Needs a cleanup apparently
    useEffect(() =>{
        axios.get('http://localhost:8081/brewery/all')
             .then(res => {
                console.log(res.data);
                setBreweries(res.data);
             })
             .catch(err => {
                console.log('No Data Available: ' + err);
            })
    }, []);

return(
    <div className="BrewerySearch">
            <div className="search-container">
                <input 
                type="text" 
                className="search-brewery_box" 
                placeholder="Search by brewery name" 
                onChange={(event) => setSearchTerm(event.target.value)}
            /></div>
        

        <div className="results-container">
            {breweries.filter((val) => {
           if (searchTerm === '') {
                return val
            } else if (val.name.toLowerCase().includes(searchTerm.toLowerCase())){
                return val
            }
            }
           ).map((brewery,key) =>{
                return (
                        <DetailedBrewery brewery = {brewery} key = {key} />
                    )
            })}
        </div>        
    </div>
    )
};



// {/* <h1>Feeling Thristy?</h1>
// <input type="search" placeholder="search for a brewery"></input>
// <button onClick={()=> getAllBreweries()}>Get All Breweries</button>
// <div>
//     {breweries.map(brewery => 
//     <div className="brewery_card" key={brewery.id}>
    
//     <p className="brewery_name">{brewery.name}</p>
//     <p className="brewery_location">{brewery.location}</p>
//     </div>
    
//     )}
// </div> */}


                    //What if I just pass brewery as the prop?  
            //      <div className="brewery_card" key={key}>
            //          <p className="brewery_name">{brewery.name}</p>
            //          <p className="brewery_location">{brewery.location}</p>
            //      </div> 