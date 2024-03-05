document.addEventListener("DOMContentLoaded", function() {
    fetch('/weather')
        .then(response => response.json())
        .then(data => {
            const weatherDiv = document.getElementById('weather');
            weatherDiv.innerHTML = `
                <h2>Date: ${data.date}</h2>
                <p>Temperature: ${data.temperature}</p>
                <p>Wind: ${data.wind}</p>
                <p>Pressure: ${data.pressure}</p>
                <p>Humidity: ${data.humidity}</p>
            `;
        })
        .catch(error => console.error('Error fetching weather data:', error));
});
