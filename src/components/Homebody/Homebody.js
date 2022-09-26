import React, { Component } from 'react';
import "./Homebody.css"
import room from "./images/room.jpg"
import outside from "./images/outside.jpg"
import ServicesService  from '../Service/ServicesService';
class Homebody extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             message: ''
        }
    }

    componentDidMount(){
        ServicesService.getHome().then(response => {
            console.log(response.data);
            this.setState({ message: response.data });
            console.log("Welcome "+this.state.message.toString());
        }
          )
          .catch(function (ex) {
              console.log('Response parsing failed. Error: ', ex);
          });;
    }

    render() {
        return (
            <div>

                <div class="card" >
                    <img src={outside} class="card-img-top" alt="loading" />
                    <div class="card-body">
                        <p class="card-text">Jamsetji Nusserwanji Tata, founder of the Tata Group, opened the Taj Mahal Palace, a hotel in Mumbai (formerly called Bombay) overlooking the Arabian Sea, on 16 December 1903. It was the first Taj property and the first Taj hotel. There are several anecdotal stories about why Tata opened the Taj hotel. According to a story, he decided to open the hotel after an incident involving racial discrimination at the Watson's Hotel in Mumbai, where he was refused entry as the hotel permitted only Europeans. Hotels that accepted only European guests were very common across British India then. According to another story, he opened the hotel when one of his friends expressed disgust over the hotels that were present in Bombay then. But a more plausible reason was advanced by Lovat Fraser, a close friend of the Tata and one of the early directors of the IHCL group, that the idea had long been in his mind and that he had made a study on the subject. He did not have any desire to own a hotel but he wanted to attract people to India and to improve Bombay. It is said that Jamsetji Tata had travelled to places like London, Paris, Berlin, and Düsseldorf to arrange for materials and pieces of art, furniture and other interior decor for his hotel</p>
                    </div>
                </div>

                <div class="card">
                    <img src={room} class="card-img-top" alt="loading" />
                    <div class="card-body">
                        <p class="card-text">In 1980, the Taj Group opened its first hotel outside India, the Taj Sheba Hotel in Sana'a, in Yemen and in the late 1980s, acquired interests in the St. James' Court Hotel (now comprising Taj 51 Buckingham Gate Suites and Residences and St. James' Court, A Taj Hotel) in London. In 1984, the Taj Group acquired, under a license agreement, each of the Taj West End in Bangalore, Taj Connemara, in Chennai and Savoy Hotel in Ooty. The five-star deluxe hotel, Taj Bengal in Kolkata, was opened in the year 1989, and with this, the Taj Group became the only hotel chain in India with a presence in the six major metropolitan cities of India, namely Mumbai, Delhi, Kolkata, Bangalore, Hyderabad, and Chennai.</p>
                    </div>
                </div>

                <div>
                    <h3>{this.state.message}</h3>
                </div>
            </div>
        )
    }
}

export default Homebody;